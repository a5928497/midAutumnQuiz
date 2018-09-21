$(function () {
   var boxWidth = $(window).width();
   var boxHeight = $(window).height();
   var oc = $("#oc");
   //初始化画布
   oc.width(boxWidth);
   oc.height(boxHeight);

   if (oc[0].getContext) {
      //获取画笔
      var ctx = oc[0].getContext("2d");
      ctx.fillStyle = "rgb(120,58,5)";
      drawTitle("你好啊");

      function drawTitle(title) {
          ctx.save();
          ctx.font = "8px sans-serif";
          // ctx.textBaseline = 'middle';
          var titleWidth = ctx.measureText(title).width;
          var titleX = Math.floor((boxWidth-titleWidth)/2);
          var titleY = Math.floor(boxHeight * 0.22);
          ctx.beginPath();
          ctx.fillText(title,titleX,titleY);
          ctx.restore();
      }
   }
});