$(function () {
   var $btns = $("button");
   var puzzleLeft = $("#puzzleSize").val();
   var favorLeft = -1;
   $btns.click(function () {
      //若有问题剩余，则继续答题
      if (puzzleLeft >0) {
          //若选择了正确的答案
          if ($(this).attr("id") == "option" + $("#answer").val()) {
              --puzzleLeft;
              $("#puzzleSize").val(puzzleLeft);
              //还有下一题，请求下一题
              if (puzzleLeft != 0) {
                  var uri = "/getnextpuzzle/" + $("#order").val();
                  $.get(uri,function (data) {
                      if (null != data) {
                          $(".title").text(data.title);
                          $("#optionA").text(data.optionA);
                          $("#optionB").text(data.optionB);
                          $("#optionC").text(data.optionC);
                          $("#optionD").text(data.optionD);
                          $("#answer").val(data.answer);
                          $("#order").val(data.order);
                          $("#puzzleSize").val(puzzleLeft);
                      }
                  });
              }
              //没有下一题，获取第一个喜好测试
              else{
                  var uri = "/getfirstfavor";
                  $.get(uri,function (data) {
                      if (null != data) {
                          $(".title").text(data.title);
                          $("#optionA").text(data.optionA);
                          $("#optionB").text(data.optionB);
                          $("#optionC").text(data.optionC);
                          $("#optionD").text(data.optionD);
                          $("#answer").remove();
                          $("#order").val(data.order);
                          $("#puzzleSize").remove();
                          favorLeft = data.size;
                      }
                  });
              }
          }
          //若选择了错误的答案
          else {
              alert("答案不正确，再仔细想想！");
          }
      }
      //若问题答完，则进入喜好测试
      else {
         favorLeft--;
         //若爱好问题未完，则继续请求下一个
         if (favorLeft > 0 ) {
             var uri = "/getnextfavor/" + $("#order").val();
             $.get(uri,function (data) {
                 if (null != data) {
                     $(".title").text(data.title);
                     $("#optionA").text(data.optionA);
                     $("#optionB").text(data.optionB);
                     $("#optionC").text(data.optionC);
                     $("#optionD").text(data.optionD);
                     $("#order").val(data.order);
                 }
             });
         }
          //若爱好问题已完，跳转到结果
          if(favorLeft == 0) {
             var sign = $(this).attr("sign");
              //完整路径
              var curWwwPath=window.document.location.href;
              //后缀
              var pathName=window.document.location.pathname;
              //前缀
              var localhostPaht=curWwwPath.substring(0,curWwwPath.indexOf(pathName));
              window.location.replace(localhostPaht + "/getresult/" + sign);
          }
      }
      return false;
   });
});