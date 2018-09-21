$(function () {
   var boxWidth = $(window).width();
   var boxHeight = $(window).height();
   var oc = $("#oc");
   //初始化画布
   oc.width(boxWidth);
   oc.height(boxHeight);

   if (oc.getContext) {
      //获取画笔
      var ctx = oc.getContext("2d");
   }
});