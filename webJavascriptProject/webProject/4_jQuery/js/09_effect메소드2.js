$(function(){
    $("div").on("click", function(){
        
        if( $(this).next("p").css("display")=="none" ){ // 만약에 클릭하는 요소가 열려있지 않으면

            $(this).siblings("p.contents").slideUp(); // 형제 요소 p 닫고
            $(this).next("p").slideDown(); // 자신의 p 열기

        } else {

            $(this).next("p").slideUp();
        }
    });
});
