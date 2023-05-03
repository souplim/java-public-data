/*
구글 크롬(Google Chrome)80버전부터 새로운 쿠키 정책이 적용되어 
Cookie의  SameSite 속성의 기본값이 "None"에서 "Lax"로 변경되었다.

다시말해 SameSite는 말 그대로 쿠키 전송에 있어 '같은 사이트'인지 체크하는 것인데 
Cookie의 SameSite 속성은 서로 다른 도메인간의 쿠키 전송에 대한 보안을 설정한다. 
Strict는 같은 사이트에서만 쿠키 전송, Lax는 허용한 사이트와 같은 사이트에서만, None은 모든 사이트에서를 의미한다. 

SameSite 속성을 None으로 설정할 경우 모든 도메인에서 쿠키를 전송하고 사용할 수 있지만  
사용자가 사이트간 요청위조(CSRF - Cross-site request forgery) 및 의도하지 않은 정보 유출에 취약해질 가능성이 있다. 
이러한 취약점을 방지하기 위해 지금까지는 별도의 SameSite 속성 명시 없이 쿠키를 생성했을 때 "SameSite=None"으로 
설정한 것과 동일하게 동작했지만 Chrome80 버전 이후에는 SameSite 속성 설정이 없는 쿠키는 "SameSite=Lax"로 
명시한 것과 동일하게 동작한다는 것이다. 
*/
document.cookie = "safeCookie1=foo; SameSite=Lax";
document.cookie = "safeCookie2=foo";
document.cookie = "crossCookie=bar; SameSite=None; Secure";