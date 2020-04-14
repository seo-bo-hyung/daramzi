
//sql injection 막기위한 검사
function validateLogin(){

 var id = document.forms[0].id; 

 var pw = document.forms[0].pw;

 if(id.value == "") {

  alert("id is null");

  id.focus();

  return false;

 }else if(id.value.indexOf("'") != -1){
      alert("you can't use single qutation!");
      id.value = "";
      id.focus();
      return false;
 }

 if(pw.value == "") {

  alert("pw is null");

  pw.focus();

      return false;

 }else if(pw.value.indexOf("'") != -1){
      alert("you can't use single qutation!");
      pw.value = "";
      pw.focus();
      return false;
 }

}
