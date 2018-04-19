/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['ojs/ojcore', 'ojs/ojtable', 'ojs/ojchart', 'knockout', 'jquery', 'ojs/ojknockout', 'ojs/ojselectcombobox', 'ojs/ojdatetimepicker', 'ojs/ojtimezonedata'],
 function(oj, ojtable, ojchart, ko, $) {
  
    function DashboardViewModel() {
       var self = this;

      // Below are a subset of the ViewModel methods invoked by the ojModule binding
      // Please reference the ojModule jsDoc for additionaly available methods.

      /**
       * Optional ViewModel method invoked when this ViewModel is about to be
       * used for the View transition.  The application can put data fetch logic
       * here that can return a Promise which will delay the handleAttached function
       * call below until the Promise is resolved.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       * @return {Promise|undefined} - If the callback returns a Promise, the next phase (attaching DOM) will be delayed until
       * the promise is resolved
       */
      self.handleActivated = function(info) {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after the View is inserted into the
       * document DOM.  The application can put logic that requires the DOM being
       * attached here.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       * @param {boolean} info.fromCache - A boolean indicating whether the module was retrieved from cache.
       */
      self.handleAttached = function(info) {
        // Implement if needed
         this.gteValue = ko.observable(oj.IntlConverterUtils.dateToLocalIso(new Date(2013, 0, 1))); // start time
         this.lteValue = ko.observable(oj.IntlConverterUtils.dateToLocalIso(new Date())); // end time

         var aAvailableFields = [{
            fieldName: "hostip",
            showButton: true
         },{
            fieldName: "status",
            showButton: true
         },{
            fieldName: "message",
            showButton: true
         }];
         var aLogData = [{timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"},
            {timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"},
            {timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"},
            {timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"},
            {timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"},
            {timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"},
            {timestamp: "a", hostip: "sdfadsa", status: "c", message: "d"}];
         this.selectedFields = ko.observableArray([{
            fieldName: "timestamp",
            showButton: false
         }]);
         this.availableFields = ko.observableArray(aAvailableFields);
         this.logDataTableHeader = ko.observableArray([{headerText: "timestamp", field: "timestamp"}]);
         this.datasource = new oj.ArrayTableDataSource(aLogData, {idAttribute: 'timestamp'});

         this.addField = function() {
            self.availableFields.remove(this);
            self.selectedFields.push(this);
            var column = {headerText: this.fieldName, field: this.fieldName};
            self.logDataTableHeader.push(column);
         };

         this.removeField = function() {
            self.selectedFields.remove(this);
            self.availableFields.push(this);
            var that = this;
            self.logDataTableHeader.remove(function(item) {
               return item.field === that.fieldName;
            });
         };

         var logCountBuckets = [29,26,14,27,38,56,29,22,30,37,59,54,51,50,48,39,46,38,35,41,
            26,18,22,19,38,26,47,21,27,30,43,42,55,41,35,33,28,30,29,30,30,25,23,36,37,
            35,33,29,35,36,48,44,50,52,45,29,32,30,25,36,40,30,31,29,25,34,55,43,44,60,
            46,37,39,57,37,27,33,41,52,45,57,44,33,39,35,46,60,52,43,42,47,46,54,44,54,
            59,59,65,59,60,69,69,63,75,68,45,40,42,63,48,69,73,57,59,57,47,50,54,44,45,
            60,69,67,62,66,64,69,62,59,80,80,85,52,63,77,73,75,63,68,69,65,59,57,61,66,
            79,74,50,58,66,60,66,83,72,60,60,76,80,81,81,79,63,66,64,77,80,73,84,87,84,
            77,75,71,77,84,89,81,72,80,86,89,89,91,92,76,80,85,88,92,88,82,73,80,85,86,
            85,76,81,76,72,72,73,87,92,76,83,85,80,84,79,78,81,82,72,70,80,82,83,79,85,
            78,80,84,82,69,77,75,78,81,79,74,74,72,72,72,75,81,85,91,82,71,79,85,85,93,
            85,83,91,92,76,71,69,70,80,68,67,66,67,65,69,75,56,73,82,74,72,66,62,69,81,
            87,74,57,57,56,55,63,61,67,73,73,66,63,54,59,63,78,81,70,71,71,56,58,62,56,
            54,52,64,59,63,60,74,59,54,49,42,53,57,66,51,49,48,56,58,63,60,50,44,40,42,
            48,44,37,48,36,44,59,65,62,50,38,35,34,57,64,42,51,43,42,45,38,29,49,48,39,
            39,42,45,42,44,49,44,37,36,36,44,47,46,59,50,52,52,41,30,30];
         var timestampBuckets = [];
         for (var i = 0; i < 365; i++) {
            timestampBuckets.push(1388552400000 + 86400000*i);
         }

         var colorHandler = new oj.ColorAttributeGroupHandler();
         colorHandler.addMatchRule("high", '#ed6647');
         colorHandler.addMatchRule("low", '#267db3');
         var series = [{name: "Count", items: logCountBuckets, color: colorHandler.getValue("low")}];

         this.seriesValue = ko.observableArray(series);
         this.groupsValue = ko.observableArray(timestampBuckets);

         this.tags = ko.observableArray([
            { value: "status:200", label: "status:200" }
         ]);

         var onQuerySuccess = function(data) {
            var jsonObject = JSON.parse();
            var logCountBuckets = [];
            var timestampBuckets = [];
            var buckets = jsonObject.buckets;
            for (var i = 0; i < buckets.length; i++) {
               logCountBuckets.push(buckets[i].loc_count);
               timestampBuckets.push(buckets[i].timestamp);
            }
            self.seriesValue[0].items = logCountBuckets;
            self.groupsValue = timestampBuckets;

            var hits = jsonObject.hits.data;
            self.datasource.reset(hits, {idAttribute: 'timestamp'});
         };

         var executeQuery = function(queryString) {
            var size = 500;
            var sort = {timestamp:{order:"desc"}};
            var gte = new Date(self.gteValue()).getTime();
            var lte = new Date(self.lteValue()).getTime();
            // if (!lte) {
            //    lte = new Date().getTime();
            // }
            // if (!gte) {
            //    gte = lte - 24 * 60 * 60 * 1000;
            // }
            var range = {timestamp:{gte: gte, lte: lte, format: "epoch_millis"}};
            var date_histogram = {field: "timestamp", interval:"30m"};
            var dataLoad = {queryString: queryString, size: size, sort: sort, range: range, date_histogram: date_histogram};

            $.ajax({
               type: 'POST',
               url: 'http://172.31.23.13:8080/LoganSystem/discover/executeQuery',
               data: JSON.stringify(dataLoad, null),
               success: onQuerySuccess,
               contentType: "application/json",
               dataType: 'json'
            });
         };

         this.valueChangeHandler = function (context, ui) {
            if (ui.option === "value") {
               var valueObj = {
                  previousValue: ui.previousValue,
                  value: ui.value
               };
               executeQuery(ui.value[0]);
            }
         };

         this.previousValue = null;
         this.updateEventHandler = function (context, ui) {
            var valueObj = {
               previousValue: this.previousValue,
               value: ui.value
            };
            this.previousValue = ui.value;
            var queryString;
            if (!ui.value) {
               queryString = "*";
            }
            executeQuery(queryString);
         };

      };


      /**
       * Optional ViewModel method invoked after the bindings are applied on this View. 
       * If the current View is retrieved from cache, the bindings will not be re-applied
       * and this callback will not be invoked.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       */
      self.handleBindingsApplied = function(info) {
        // Implement if needed
      };

      /*
       * Optional ViewModel method invoked after the View is removed from the
       * document DOM.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       * @param {Array} info.cachedNodes - An Array containing cached nodes for the View if the cache is enabled.
       */
      self.handleDetached = function(info) {
        // Implement if needed
      };
    }

    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new DashboardViewModel();
  }
);
