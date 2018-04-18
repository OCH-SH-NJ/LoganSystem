package com.logan.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.apache.livy.LivyClient;
import org.apache.livy.LivyClientBuilder;
import org.springframework.stereotype.Repository;

import com.logan.SparkJob.PiJob;

@Repository
public class SparkWorkFlow {

	
	public Double testSparkWork() throws IOException, URISyntaxException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		LivyClient client = new LivyClientBuilder().setURI(new URI("http://192.168.109.130:8998")).build();
		try {
			System.err.printf("Uploading %s to the Spark context...\n", "D:/PI.jar");
			client.uploadJar(new File("D:/PI.jar")).get();

			System.err.printf("Running PiJob with %d samples...\n", 3);
			Double pi = client.submit(new PiJob(3)).get();

			return pi;
		} finally {
			client.stop(true);
		}
	}

}
