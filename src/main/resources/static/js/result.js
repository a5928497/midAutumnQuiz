$(function () {
    var boxWidth = $(window).width();
    var boxHeight = $(window).height();
    var $oc = $("#oc");
    var img_id = $("#id").val();
    var poet = $("#poet").val();
    var dynasty =$("#dynasty").val();
    //完整路径
    var curWwwPath=window.document.location.href;
    //后缀
    var pathName=window.document.location.pathname;
    //前缀
    var localhostPaht=curWwwPath.substring(0,curWwwPath.indexOf(pathName));
    var img_url  =localhostPaht + "/poet_images/poet"+ img_id +".png";
    $oc[0].width = boxWidth;
    $oc[0].height = boxHeight;

    if ($oc[0].getContext) {
        var ctx = $oc[0].getContext("2d");

        ctx.save();
        ctx.beginPath();
        var img = new Image();
        img.src = img_url;
        img.onload = function () {
            var precent1 = Math.floor(Math.random()*80);
            var precent2 = 100 - precent1;
            var poetText = "与" + poet + "相似程度为" + precent1 +"%";
            var dynastyText ="举止行为最像" + dynasty + "朝人士";
            drawBg(img);
            ctx.fillStyle = "black";
            ctx.font = "20px sans-serif";
            drawPoetText(poetText);
            drawDynastyText(dynastyText);
        }
        ctx.restore();

        function drawBg(image) {
            ctx.drawImage(image,0,0,img.width,img.height,0,0,boxWidth,boxHeight);
        }

        function drawPoetText(text) {
            var w = ctx.measureText(text).width;
            var x = Math.floor((boxWidth-w)/2);
            ctx.fillText(text,x,boxHeight*0.78);
        }
        function drawDynastyText(text) {
            var w = ctx.measureText(text).width;
            var x = Math.floor((boxWidth-w)/2);
            ctx.fillText(text,x,boxHeight*0.83);
        }
    }
});