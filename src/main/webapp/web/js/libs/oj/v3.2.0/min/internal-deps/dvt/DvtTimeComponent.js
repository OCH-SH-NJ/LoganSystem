/**
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
"use strict";
define(['./DvtToolkit'], function(dvt) {
  // Internal use only.  All APIs and functionality are subject to change at any time.

var ga;function ka(a,E){0==a.indexOf("dvt.")&&(a=a.substring(4));var B=a.split("."),q=eval("dvt");B[0]in q||!q.execScript||q.execScript("var "+B[0]);for(var w;B.length&&(w=B.shift());)B.length||void 0===E?q=q[w]?q[w]:q[w]={}:q[w]=E}Math.floor(2147483648*Math.random()).toString(36);
(function(a){a.wd=function(a,q,w){this.Init(a,q,w)};a.i.v(a.wd,a.mc);a.wd.fAa=1.5;a.wd.Sga=15;a.wd.GQa=40;a.wd.prototype.Init=function(B,q,w){a.wd.C.Init.call(this,B,q,w);this.m0a=!1};a.wd.prototype.ha=function(a,q,w){a&&(this.Ok=a._resources,null==this.Ok&&(this.Ok=[]),this.Le(a));this.Ra=q;this.fb=w;this.K&&(a=this.Av(this.K),this.Bp(a))};a.wd.prototype.Le=function(B){this.K=this.Vf.Io(B);a.m.Xk()||(this.K.animationOnDisplay="none",this.K.animationOnDataChange="none")};a.wd.prototype.KQ=function(){this.ie&&
this.ie.di()};a.wd.prototype.Bp=function(a){this.Wa=a.start;this.ub=a.end;this.jP=a.Ny;this.Su()};a.wd.prototype.Su=function(){this.oe&&this.oe.ul(this.jP)};a.wd.prototype.nA=function(a){this.Bc=this.be<a?a:this.be;this.m0a||(this.om=0,this.uk=this.Bc)};a.wd.prototype.dg=function(){return a.m.ca(this.a)};a.wd.prototype.Ia=function(){return this.Nc};a.wd.prototype.Vq=function(){return null};a.wd.prototype.SV=function(){this.vt(0);if(this.nb&&this.bc){var a=this.bc-this.nb;0<a&&(a=this.be/a,this.nA(a*
(this.ub-this.Wa)),this.vt(a*(this.Wa-this.nb)))}else{var a=this.Vq(),a=a.fL[a.pl],q=this.Wa,w=this.ub;null==this.nb?null!=this.bc?(this.nb=this.bc-this.be/a*(w-q),this.nb<this.Wa&&(this.nb=this.Wa),a=this.bc-this.nb,a=this.be/a,this.nA(a*(this.ub-this.Wa)),this.vt(a*(this.Wa-this.nb))):(this.nb=this.Wa,this.vt(0),this.bc=this.be/a*(w-q)+this.nb,this.bc>this.ub&&(this.bc=this.ub)):(this.bc=this.be/a*(w-q)+this.nb,this.bc>this.ub&&(this.bc=this.ub),a=this.bc-this.nb,a=this.be/a,this.nA(a*(this.ub-
this.Wa)),this.vt(a*(this.Wa-this.nb)))}};a.wd.prototype.YV=function(B){this.Dj?this.Dj.he(null):this.Dj=new a.ba(this.a,"iCanvas");var q=new a.jc;this.Ia()?(q.ue(this.Sf,this.lj,this.Re,this.be),this.Dj.Ja(this.Sf),this.Dj.wb(this.lj+this.aL)):(q.ue(this.Sf,this.lj,this.be,this.Re),this.Dj.Ja(this.Sf+this.aL),this.Dj.wb(this.lj));B.he(q);this.Dj.getParent()!=B&&B.B(this.Dj)};a.wd.prototype.jwa=function(B){var q=this.a,w=this.Vq(),x=B.zoomInProps,h=x.imageSize,d=x.cssUrl,f=x.cssUrlHover,b=x.cssUrlActive,
e=x.cssUrlDisabled,l=x.enabledBackgroundColor,g=x.enabledBorderColor,E=x.hoverBackgroundColor,r=x.hoverBorderColor,k=x.activeBackgroundColor,y=x.activeBorderColor,t=x.disabledBackgroundColor,F=x.disabledBorderColor,d=a.Bf.UI(q,d,h,h,l,g),f=a.Bf.UI(q,f,h,h,E,r),b=a.Bf.UI(q,b,h,h,k,y),h=a.Bf.UI(q,e,h,h,t,F),C=x.posX,x=x.posY;null==this.Km?(this.Km=new a.Bf(q,d,f,b,h,this.u,this.u.U7),this.u.Yb(this.Km,this.Km)):(this.Km.oW(d),this.Km.iW(f),this.Km.cW(b),this.Km.H6(h));B=B.zoomOutProps;h=B.imageSize;
d=B.cssUrl;f=B.cssUrlHover;b=B.cssUrlActive;e=B.cssUrlDisabled;l=B.enabledBackgroundColor;g=B.enabledBorderColor;E=B.hoverBackgroundColor;r=B.hoverBorderColor;k=B.activeBackgroundColor;y=B.activeBorderColor;t=B.disabledBackgroundColor;F=B.disabledBorderColor;d=a.Bf.UI(q,d,h,h,l,g);f=a.Bf.UI(q,f,h,h,E,r);b=a.Bf.UI(q,b,h,h,k,y);h=a.Bf.UI(q,e,h,h,t,F);e=B.posX;B=B.posY;null==this.Lm?(this.Lm=new a.Bf(q,d,f,b,h,this.u,this.u.V7),this.u.Yb(this.Lm,this.Lm)):(this.Lm.oW(d),this.Lm.iW(f),this.Lm.cW(b),this.Lm.H6(h));
this.Km.zq(a.I.Ka(a.I.ua,"ZOOM_IN",null));this.Lm.zq(a.I.Ka(a.I.ua,"ZOOM_OUT",null));this.Km.rt();this.Lm.rt();a.Va.bj()&&(a.l.H(this.Km.oa(),"role","button"),a.l.H(this.Km.oa(),"aria-label",a.I.Ka(a.I.ua,"ZOOM_IN",null)),a.l.H(this.Lm.oa(),"role","button"),a.l.H(this.Lm.oa(),"aria-label",a.I.Ka(a.I.ua,"ZOOM_OUT",null)));this.Km.Ja(C);this.Lm.Ja(e);this.Km.wb(x);this.Lm.wb(B);this.Km.getParent()!=this.ie&&this.ie.B(this.Km);this.Lm.getParent()!=this.ie&&this.ie.B(this.Lm);q=this.Bc;q>=w.yP&&this.lL(!0);
this.be>=q&&this.lL(!1)};a.wd.prototype.LM=function(B){a.u.Zd(B);var q=B.wheelDelta,w=B.ph();if(this.sq()&&(null!=w.wheelDeltaX?B.wheelDeltaX=w.wheelDeltaX/a.wd.GQa:null!=w.deltaX&&(w.deltaMode==w.DOM_DELTA_LINE?B.wheelDeltaX=-w.deltaX:w.deltaMode==w.DOM_DELTA_PIXEL&&(B.wheelDeltaX=-w.deltaX/a.wd.Sga)),q)){var w=this.a.av(),w=this.Nc?B.pageY-w.y:B.pageX-w.x,x=(this.ub-this.Wa)/this.Bc,x=this.dg()&&!this.Nc?this.bc-x*w:x*w+this.nb;B.Vxa=x;B.Uxa=w;B.rW=.02*q+1}};a.wd.prototype.KC=function(a,q,w){var x=
(this.bc-this.nb)/(this.ub-this.Wa)*this.Bc;this.nA(a);a=x/this.Bc*(this.ub-this.Wa);q?(x=(this.ub-this.Wa)/this.Bc,this.dg()&&!this.Nc?(this.bc=q+w*x,this.bc>this.ub&&(this.bc=this.ub),this.nb=this.bc-a,this.nb<this.Wa&&(this.nb=this.Wa,this.bc=this.nb+a,this.bc>this.ub&&(this.bc=this.ub))):(this.nb=q-w*x,this.nb<this.Wa&&(this.nb=this.Wa),this.bc=this.nb+a,this.bc>this.ub&&(this.bc=this.ub,this.nb=this.bc-a,this.nb<this.Wa&&(this.nb=this.Wa))),this.vt(1/x*(this.Wa-this.nb))):(this.nb=this.Wa,this.bc=
this.nb+a,this.nb<this.Wa&&(this.nb=this.Wa),this.vt(0));this.hE()};a.wd.prototype.dz=function(a){var q=this.Nc?this.fb/2:this.Ra/2;this.KC(this.Bc*((1/a-1)/2+1),(this.ub-this.Wa)/this.Bc*q+this.nb,q,!0)};a.wd.prototype.d1a=function(a,q,w,x){this.A$=this.Nc?Math.sqrt((q-x)*(q-x))+(q<x?q:x):Math.sqrt((a-w)*(a-w))+(a<w?a:w);var h=(this.ub-this.Wa)/this.Bc;this.dg()&&!this.Nc?this.fna=this.bc-h*this.A$:this.fna=h*this.A$+this.nb;this.ena=Math.sqrt((a-w)*(a-w)+(q-x)*(q-x));this.DEa=this.Bc};a.wd.prototype.x1a=
function(a,q,w,x){a=Math.sqrt((a-w)*(a-w)+(q-x)*(q-x));a!=this.ena&&(this.qC=!0);this.KC(a/this.ena*this.DEa,this.fna,this.A$,!1)};a.wd.prototype.a2a=function(){this.fna=this.DEa=this.A$=this.ena=null;this.qC&&(this.qC=!1,this.dispatchEvent(this.jp()))};a.wd.prototype.m6=function(a){if(this.Nc){a=this.Dj.Rb()-a;var q=-(this.Bc-this.be-this.lj),w=this.lj;a<q?a=q:a>w&&(a=w);this.Dj.wb(a);a-=this.lj;this.qLa(a)}else a=this.Dj.Jb()-a,q=-(this.Bc-this.be-this.Sf),w=this.Sf,a<q?a=q:a>w&&(a=w),this.Dj.Ja(a),
this.qLa(a-this.Sf),a=this.qta();q=this.Bc/(this.ub-this.Wa);w=this.bc-this.nb;this.nb=this.Wa-a/q;this.bc=this.nb+w};a.wd.prototype.RJa=function(B){B?this.dz(1/a.wd.fAa):this.dz(a.wd.fAa)};a.wd.prototype.eV=function(a){a?(this.Km.ut(!0),this.Km.$r()):(this.Lm.ut(!0),this.Lm.$r())};a.wd.prototype.lL=function(a){a?(this.Km.ut(!1),this.Km.cV(),this.Km.setCursor(null)):(this.Lm.ut(!1),this.Lm.cV(),this.Lm.setCursor(null))};a.wd.prototype.hE=function(){this.Nc?this.Dj.wb(this.lj+this.aL):this.Dj.Ja(this.Sf+
this.aL)};a.wd.prototype.qLa=function(a){this.aL=a};a.wd.prototype.qta=function(){return this.dg()&&!this.Nc?this.be-this.Bc-this.aL:this.aL};a.wd.prototype.vt=function(a){this.dg()&&!this.Nc?this.aL=this.be-this.Bc-a:this.aL=a};a.wd.prototype.LE=function(a){this.Sf=a};a.wd.prototype.sxa=function(a){this.lj=a};a.wd.prototype.D4=function(){return this.Ia()?new a.U(this.Sf,this.lj,this.Re,this.be):new a.U(this.Sf,this.lj,this.be,this.Re)};a.wd.prototype.pp=function(){return!0};a.wd.prototype.txa=function(a){this.Qi=
a};a.wd.prototype.Cwa=function(a,q){null!=q?(null==this.Ne&&(this.Ne=[]),this.Ne[q]=a):this.Ne=a};a.wd.prototype.HR=function(){return E.$Aa};a.wd.prototype.w5=function(){return E.w5()};a.wd.prototype.r4=function(){return E.r4()};a.wd.prototype.lz=function(B,q){B.type==a.sk.Nd&&(B=this.qJ(B,q));B&&this.dispatchEvent(B)};a.wd.prototype.qJ=function(a,q){if(q==this.Qi){var w=a.T$;this.nb=a.Yx;this.bc=w;this.vt(this.Bc/(this.ub-this.Wa)*(this.Wa-this.nb));this.hE();w=this.jp();this.dispatchEvent(w)}};
a.wd.prototype.Lf=function(a){a&&this.dispatchEvent(a)};a.wd.prototype.jp=function(){return null};a.wd.prototype.KM=function(){};a.wd.prototype.lT=function(){};a.wd.prototype.xOa=function(a){null!=this.Km&&this.Km.M1(a);null!=this.Lm&&this.Lm.M1(a)};a.wd.prototype.tOa=function(a){null!=this.Km&&this.Km.J1(a);null!=this.Lm&&this.Lm.J1(a)};a.wd.prototype.HQ=function(a,q){this.Nka=a;this.Oka=q};a.wd.prototype.kE=function(){this.fV()};a.wd.prototype.R7=function(a){"none"!=this.gq&&this.eca(a,"multiple"==
this.gq)};a.wd.prototype.eca=function(){};a.wd.prototype.AOa=function(a){this.eca(a,a.ctrlKey&&"multiple"==this.gq)};a.wd.prototype.fV=function(){this.qC&&(this.qC=!1,this.dispatchEvent(this.jp()))};a.wd.prototype.W3=function(a,q){if(this.Nka&&this.Oka){var w=this.Nka-a,x=this.Oka-q;if(0==w&&0==x)return!1;this.qC=!0;this.Nka=a;this.Oka=q;this.mi(w,x);return!0}return!1};a.wd.prototype.mi=function(a){this.m6(a)};a.Hg=function(a){this.Init(a.a,a.Lf,a);this.vi=a;this.xna=this.mU=!1};a.i.v(a.Hg,a.u);a.Hg.Cya=
"wheel";a.Hg.prototype.Kf=function(B){a.Hg.C.Kf.call(this,B);a.me.$U(this.vi,this.EH,this.DH,this.CH,this);a.m.mb()||(a.m.Yk()?B.lb(a.Hg.Cya,this.oD,!1,this):B.lb(a.MouseEvent.CF,this.oD,!1,this))};a.Hg.prototype.ax=function(B){a.Hg.C.ax.call(this,B);a.m.mb()||(a.m.Yk()?B.Uc(a.Hg.Cya,this.oD,!1,this):B.Uc(a.MouseEvent.CF,this.oD,!1,this))};a.Hg.prototype.YM=function(B){a.Hg.C.YM.call(this,B);this.vi.xOa(B)};a.Hg.prototype.Ww=function(B){a.Hg.C.Ww.call(this,B);this.vi.tOa(B)};a.Hg.prototype.FF=function(B){a.Hg.C.FF.call(this,
B);this.vi.KM(B)};a.Hg.prototype.wj=function(B){this.mU||(a.Hg.C.wj.call(this,B),this.vi.AOa(B))};a.Hg.prototype.dN=function(B){this.mU=!1;a.Hg.C.dN.call(this,B);this.vi.lT(B)};a.Hg.prototype.oD=function(a){this.vi.LM(a)};a.Hg.prototype.bN=function(B){a.Hg.C.bN.call(this,B);this.vi.pT(B);this.vi.a.Fc.St.parentNode.focus()};a.Hg.prototype.aN=function(B){a.Hg.C.aN.call(this,B);this.vi.R7(B)};a.Hg.prototype.EH=function(B){if(this.vi.sq())return a.m.mb()?this.W1(B):this.P1(B)};a.Hg.prototype.DH=function(B){return a.m.mb()?
this.V1(B):this.O1(B)};a.Hg.prototype.CH=function(B){return a.m.mb()?this.U1(B):this.N1(B)};a.Hg.prototype.Ss=function(B,q){this.kC||(this.kC=this.a.av());return new a.N(B-this.kC.x,q-this.kC.y)};a.Hg.prototype.P1=function(B){return B.button!=a.MouseEvent.h8&&(B=this.Ss(B.pageX,B.pageY),this.vi.D4().mf(B.x,B.y))?(this.vi.HQ(B.x,B.y),!0):!1};a.Hg.prototype.O1=function(a){a=this.Ss(a.pageX,a.pageY);this.vi.W3(a.x,a.y)&&(this.mU=!0)};a.Hg.prototype.N1=function(){this.vi.kE();this.kC=null};a.Hg.prototype.W1=
function(B){var q=B.touches,w=this.vi.D4();if(1==q.length){if(B=this.Ss(q[0].pageX,q[0].pageY),w.mf(B.x,B.y))return this.vi.HQ(B.x,B.y),!0}else if(2==q.length){this.vi.kE();this.xna=!0;var x=this.Ss(q[0].pageX,q[0].pageY),q=this.Ss(q[1].pageX,q[1].pageY);if(w.mf(x.x,x.y)&&w.mf(q.x,q.y))return this.vi.d1a(x.x,x.y,q.x,q.y),a.u.Zd(B),!0}return!1};a.Hg.prototype.V1=function(a){var q=a.touches;if(1==q.length){var w=this.Ss(q[0].pageX,q[0].pageY);this.vi.W3(w.x,w.y);a.preventDefault()}else 2==q.length&&
(w=this.Ss(q[0].pageX,q[0].pageY),q=this.Ss(q[1].pageX,q[1].pageY),this.vi.x1a(w.x,w.y,q.x,q.y),a.preventDefault())};a.Hg.prototype.U1=function(a){this.xna?(this.xna=!1,this.vi.a2a()):this.vi.kE();a.preventDefault();this.kC=null};a.Hg.prototype.dz=function(a){this.vi.dz(a)};a.Hg.prototype.mi=function(B,q){var w=B*this.vi.be*(a.m.ca(this.a)?-1:1),x=q*this.vi.Re;0!=w&&(this.vi.qC=!0);this.vi.mi(w,x);this.vi.fV()};a.Hg.prototype.U7=function(){this.vi.RJa(!0)};a.Hg.prototype.V7=function(){this.vi.RJa(!1)};
a.Hg.prototype.jz=function(){return a.u.uD};a.cK=function(a){this.Init(a)};a.i.v(a.cK,a.Ba);a.cK.prototype.eA=function(a){return this.ci(a)&&!a.ctrlKey};a.cK.prototype.Po=function(B){return B.keyCode==a.KeyboardEvent.Pj&&B.ctrlKey};a.cK.prototype.$k=function(B){if(a.KeyboardEvent.c6(B)||a.KeyboardEvent.pca(B))this.Lc.U7();else if(a.KeyboardEvent.b6(B)||a.KeyboardEvent.wca(B))this.Lc.V7();else{var q=B.keyCode;q==a.KeyboardEvent.e8?(B.shiftKey?this.Lc.mi(-.25,0):this.Lc.mi(0,-.25),a.u.Zd(B)):q==a.KeyboardEvent.d8&&
(B.shiftKey?this.Lc.mi(.25,0):this.Lc.mi(0,.25),a.u.Zd(B))}return a.cK.C.$k.call(this,B)};var E={};a.i.v(E,a.i);E.QRa="height: 3px; width: 3px; color: #9E9E9E; background-color: #F0F0F0";E.HRa="height: 3px; width: 3px; color: #9E9E9E; background-color: #F0F0F0";E.$Aa=4;E.w5=function(){return new a.j(E.QRa)};E.r4=function(){return new a.j(E.HRa)};E.HR=function(){return E.$Aa}})(dvt);
  return dvt;
});
