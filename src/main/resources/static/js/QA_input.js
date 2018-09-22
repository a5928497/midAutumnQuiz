$(function () {
    $backBTN = $(".backBTN");
    $inputForm = $("#inputForm");
    var put_method = $("input[name='_method']").length;
    var type = $(".type").val();
    if (put_method == 0) {
        //若为添加
    }
    if (put_method == 1) {
        //若为修改
        if (type == 1){
            $inputForm.attr("action","/editpuzzle");
        }
        if (type == 2) {
            $inputForm.attr("action","/editfavor");
            $inputForm.attr("modelAttribute","favor");
            $(".answer-group").remove();
            $("#favor_option").attr("selected","selected");
        }
    }
    $("#select").change(function () {
        var type = $("#select option:selected").val();
        if (type == 2) {
            $(".answer-group").hide();
            $inputForm.attr("action","" +
                "/addfavor");
            $inputForm.attr("modelAttribute","favor");
        }
        if (type == 1) {
            $inputForm.attr("action","/addpuzzle");
            $inputForm.attr("modelAttribute","puzzle");
            $(".answer-group").show();
        }
    });

    $backBTN.click(function () {
        var uri = $backBTN.attr("back_uri");
        window.location.replace(uri);
        return false;
    });
});