document.getElementById("button").addEventListener("click", function(){
    // const arr = new Array(6);
    const arr = new Array(6);

    for(let i=0;i<arr.length;i++){
        arr[i] = Math.round(Math.random()*44+1);
    }
    
    // 로또 번호 중복 X
    for(let i=0;i<arr.length;i++){
        let comp = arr[i];
        for(let j=i+1; j<arr.length; j++){
            while(arr[j]==comp){
                arr[j] = Math.round(Math.random()*44+1);
            }
        }
    }

    // 로또에 저장된 난수 오름차순 정렬
    arr.sort(function(a,b){ return a-b; });
    console.log(arr);

    for(let i=0;i<arr.length;i++){
        document.getElementById("circle"+(i+1)).innerHTML = arr[i];
    }
})