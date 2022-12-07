// 전체선택 클릭 시
function selectAll(){
    const selectall = document.getElementById("all");
    const hobbyList = document.getElementsByName("hobby");

    // console.log(selectall.checked); 콘솔창에 all의 checked 값이 true/false인 것을 확인
    if(selectall.checked){ // 전체 선택이 체크되어 있으면
        for(let i=0; i<hobbyList.length; i++){
            hobbyList[i].checked = true;
        }
    } else { // 전체 선택이 해제되어 있으면
        for(let i=0; i<hobbyList.length; i++){
            hobbyList[i].checked = false;
        }
    }

    // 다른 더 간단한 방법: selectall의 값을 대입시켜줌
    for(let i=0; i<hobbyList.length; i++){
        hobbyList[i].checked = selectall.checked;
    }

    // 삼항연산자 사용
    for(let i=0; i<hobbyList.length; i++){
        selectall.checked ? hobbyList[i].checked = true : hobbyList[i].checked = false;
    }
}

// 선택한 카테고리 출력
function selectCategory(){
    const hobbyList = document.getElementsByName("hobby");

    let str = "";

    for(let i=0; i<hobbyList.length; i++){
        // * radio / checkbox 전용 속성 *
        // .checked : 해당 요소가 체크되어 있으면 true, 아니면 false 반환
        if(hobbyList[i].checked){ //  현재 요소가 체크되어 있으면
            // str 변수에 value 누적
            str += hobbyList[i].value + " ";
        }
    }

    // #name-div에 출력
    document.getElementById("result").innerHTML = str;
}