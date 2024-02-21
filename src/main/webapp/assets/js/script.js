//작성자 : 노희영

const id = document.querySelector('#id');
const pwd = document.querySelector('#pwd');
const pwdchk = document.querySelector('#pwdChk');
const name1 = document.querySelector('#name');
const birth = document.querySelector('#birth');
const sex = document.querySelector('#id');
const phoneNum = document.querySelector('#phoneNum');
const email = document.querySelector('#email');
const address1 = document.querySelector('#loc1');
const address2 = document.querySelector('#loc2');
const address3 = document.querySelector('#loc3');
const team = document.querySelector('#dropBox');

// chkBtn, selBtn, joinBtn 

// document.getElementById('joinBtn').addEventListener('click', function() {
//     alert('여기에 유효성 검증 구현하세요.')

// })
    id.focus();
    function save(){
        let isValid = true
        
        let regex = /^[a-zA-Z가-힣]{2,5}$/
        let regex1 = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/
        let regex2 = /^[a-zA-Z가-힣0-9]{6,15}$/
        //regex.test(name.value) [] 안에 한게 맞으면 true 아니면 false
        
        if(id.value ==''){
            alert('아이디 입력해주세요');
            id.focus();
            isValid = false;
        }else if(!regex2.test(id.value)){
            alert('아이디 입력해주세요');
            id.focus();
            isValid = false;
        }else if(pwd.value ==''){
            alert('비밀번호를 입력해주세요');
            pwd.focus();
            isValid = false;
        }else if(pwdchk.value ==''){
            alert('비밀번호 확인을 입력해주세요.');
            pwdchk.focus();
            isValid = false;
        }else if(!regex2.test(pwd.value)){
            alert('비번6이상');
            pwd.focus();
            isValid = false;
        }else if(pwd.value != pwdchk.value){
            alert('비밀번호가 일치하지 않습니다. 비밀번호 확인을 다시 입력해주세요.');
            pwdchk.focus();
            isValid = false;
        }else if(name1.value ==''){
            alert('이름을 입력해주세요');
            name1.focus();
            isValid = false;
        }else if(!regex.test(name1.value)){
            alert('이름에 기호나 숫자가 포함되어 있습니다.');
            name1.focus()
            isValid = false
        }else if(birth.value == ''){
            alert('생년월일을 입력해 주세요.');
            birth.focus();
            isValid = false;
        }else if(phoneNum.value == ''){
            alert('연락처를 입력해 주세요.');
            phoneNum.focus();
            isValid = false;
        }if((pwd.value).length < 6){
            alert('비밀번호는 6자리 이상이어야합니다.');
            pwd.focus();
            isValid = false;
        }
        
        if(isValid == true){
            document.forms[0].submit();
            alert(`${id.value}님 회원가입을 진심으로 환영합니다.`);
            alert('입력 데이터 저장완료!!')
        }           
    }

    function autoHypenPhone(str){
        str = str.replace(/[^0-9]/g, '');
        var tmp = '';
        if( str.length < 4){
            return str;
        }else if(str.length < 7){
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3);
            return tmp;
        }else if(str.length < 11){
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 3);
            tmp += '-';
            tmp += str.substr(6);
            return tmp;
        }else{              
            tmp += str.substr(0, 3);
            tmp += '-';
            tmp += str.substr(3, 4);
            tmp += '-';
            tmp += str.substr(7);
            return tmp;
        }
        return str;
    }

    phoneNum.onkeyup = function(){
        var _val = this.value.trim();
        this.value = autoHypenPhone(_val) ;
    }