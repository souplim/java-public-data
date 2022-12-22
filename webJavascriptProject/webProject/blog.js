// #topLeftMenu > li에 커서 올리면 색깔 -> 초록색, 밑줄 생기기
$("#topLeftMenu > li").hover(function(){
    $(this).css("color","#00C73C").css("borderBottom","3px solid #00C73C");
    $(this).css("fontWeight","bold");
}, function(){
    $(this).css("color","").css("borderBottom","").css("fontWeight","");
});

// #sectionNav li에 커서 올리면 밑줄 생기기
$("#sectionNav li").hover(function(){
    $(this).css("border-bottom","1px solid gray");
}, function(){
    $(this).css("border-bottom","");
});

// .userId, .titlePost > a, .text 커서 올리면 밑줄 생기기
$(".userId").hover(function(){
    $(this).css("border-bottom","1px solid gray");
}, function(){
    $(this).css("border-bottom","");
});
$(".titlePost > a").hover(function(){
    $(this).css("border-bottom","2px solid gray");
}, function(){
    $(this).css("border-bottom","");
});

// 썸네일에 커서 올리면 텍스트 변경
// $(".screen img").hover(function(){
//     $(this).prev().text("");
// }, function(){
//     $(this).prev().text("크리스마스가 일주일 앞으로 다가왔어요.");
// });
