$(function () {
    var boxWidth = $(window).width();
    var boxHeight = $(window).height();
    var $oc = $("#oc");

    $oc[0].width = boxWidth;
    $oc[0].height = boxHeight;

    if ($oc[0].getContext) {
        var ctx = $oc[0].getContext("2d");


    }
});