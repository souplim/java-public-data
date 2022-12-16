$("#btn1").on("click", function(){
    const input1 = $("#textInput1");
    $("#div1").css("backgroundColor", input1.val());
});

$("#btn2").on("click", function(){
    const input1 = $(".textInput");
    const div = $(".div");

    for(let i=0; i<div.length; i++){
        $(div[i]).css("backgroundColor", $(input1[i]).val());
    }
});

$(".textInput2").on("input", function(){

    const input2 = $(".textInput2");
    const div2 = $(".div2");

    for(let i=0; i<div2.length; i++){
        $(div2[i]).css("backgroundColor", $(input2[i]).val());
    }

    for(let i=0; i<div2.length; i++){
        $(input2[i]).css("border", "1px solid "+$(input2[i]).val());
    }

    for(let i=0; i<div2.length; i++){
        $(input2[i]).css("color", $(input2[i]).val());
    }

});
