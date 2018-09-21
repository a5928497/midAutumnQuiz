$(function () {
   var $btns = $("button");
   var puzzleLeft = $("#puzzleSize").val();
   $btns.click(function () {
      //若有问题剩余，则继续答题
      if (puzzleLeft >0) {
          //若选择了正确的答案
          if ($(this).attr("id") == "option" + $("#answer").val()) {
              --puzzleLeft;
              $("#puzzleSize").val(puzzleLeft);
              alert("你答对了，真棒！");
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
              //没有下一题，进入喜好测试
              else{
                 alert("进入喜好测试")
              }
          }
          //若选择了错误的答案
          else {
              alert("答案不正确，再仔细想想！");
          }
      }
      //若问题答完，则进入喜好测试
      else {
         alert("喜好测试");
      }

      return false;
   });
});