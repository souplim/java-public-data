$(".textInput2").on("input", function(){

    const input2 = $(".textInput2");
    const div2 = $(".div2");

    for(let i=0; i<div2.length; i++){
        $($(div2)[i]).css("backgroundColor", $(input2[i]).val());
    }

    for(let i=0; i<div2.length; i++){
        $($(input2)[i]).css("border", "1px solid "+$(input2[i]).val());
    }

    for(let i=0; i<div2.length; i++){
        $($(input2)[i]).css("color", $(input2[i]).val());
    }
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
        $(input2[i]).text("");
        // $(input2[i]).val("");
    }
});