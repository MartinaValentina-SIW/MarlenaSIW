$(document).ready(function() {
    $("input").focusout(function () {
        if($(this).val() === "")
            $(this).addClass(' is-invalid');
        else
            $(this).removeClass(' is-invalid');
    });
});