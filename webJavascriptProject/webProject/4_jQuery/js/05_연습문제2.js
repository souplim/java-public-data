$(".textInput2").on("input", function(){
    $(this).css("borderColor", $(this).val());
    $(this).prev().css("backgroundColor", $(this).val());
});

$("#btn").on("click", function(){
    const input2 = $(".textInput2");
    const div2 = $(".div2");

    for(let i=0; i<div2.length; i++){
        $(div2[i]).css("backgroundColor", "");
    }

    for(let i=0; i<div2.length; i++){
        $(input2[i]).css("border", "");
    }

    for(let i=0; i<div2.length; i++){
        $(input2[i]).css("color", "");
    }

    for(let i=0; i<div2.length; i++){
        $(input2[i]).val("");
    }
});
