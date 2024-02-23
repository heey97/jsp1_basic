//작성자 : 노희영

const id = document.querySelector('#id');
const name1 = document.querySelector('#name');
const age = document.querySelector('#age');
const email = document.querySelector('#email');

// chkBtn, selBtn, joinBtn 

// document.getElementById('joinBtn').addEventListener('click', function() {
//     alert('여기에 유효성 검증 구현하세요.')

// })
    function save(){
        let isValid = true
        
        let regex = /^[a-zA-Z가-힣]{2,5}$/
        //regex.test(name.value) [] 안에 한게 맞으면 true 아니면 false
        
        if(id.value ==''){
            alert('아이디 입력해주세요');
            id.focus();
            isValid = false;
		}else if(name1.value ==''){
            alert('이름을 입력해주세요');
            name1.focus();
            isValid = false;
        }else if(!regex.test(name1.value)){
            alert('이름에 기호나 숫자가 포함되어 있습니다.');
            name1.focus()
            isValid = false
        }else if(age.value == ''){
            alert('나이를 입력해 주세요.');
            age.focus();
            isValid = false;
        }else if(email.value == ''){
            alert('이메일 입력해 주세요.');
            email.focus();
            isValid = false;
        }
        
        if(isValid == true){
            alert(`${id.value}님 회원가입을 진심으로 환영합니다.`);
            alert('입력 데이터 저장완료!!')
            document.forms[0].submit();
        }           
    }