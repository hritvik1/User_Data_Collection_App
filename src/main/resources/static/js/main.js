function removeAddBtn() {
  document.getElementById('add').style.display = 'none'
}

function removeShowBtn() {
  document.getElementById('show').style.display = 'none'
}

function confirmDelete() {
  const confirmDel = confirm("Are You Sure You Want To Delete This User!!!!");
  if (confirmDel === true) {
    return true
  } else {
    return false
  }
}

function validate() {
  const name          = document.getElementById('userName').value,
        age           = document.getElementById('age').value,
        email         = document.getElementById('email').value,
        number        = document.getElementById('mobileNumber').value,
        address       = document.getElementById('address').value,
        error_message = document.getElementById("error_message")

  let text,
      err_symbol = "<i class=\"fas fa-exclamation-triangle\"></i>&nbsp;",
      email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  if(!name && !age && !email && !number){
    text = "Error! Empty Form.."
    error_message.innerHTML = err_symbol + text;
    return false;
  }
  if(name.length < 4 || name.length > 15){
    text = "Name should be between 4 to 15 characters in length";
    error_message.innerHTML = err_symbol + text;
    return false;
  }
  if(isNaN(age) || age.length < 1 || age.length > 2){
    text = "Enter a valid age";
    error_message.innerHTML = err_symbol + text;
    return false;
  }
  if(!email_regex.test(email)) {
    text = "Enter a valid email address";
    error_message.innerHTML = err_symbol + text;
    return false;
  }
  if(isNaN(number) || number.length != 10){
    text = "Enter a valid 10 digit phone number";
    error_message.innerHTML = err_symbol + text;
    return false;
  }
  if(address.length > 20){
    text = "Address should be less then 30 characters in length";
    error_message.innerHTML = err_symbol + text;
    return false;
  }
  error_message.innerHTML = '';
  return true;
}

function removeErrMsg() {
  if(validate()) {
    document.getElementById("error_message").innerHTML = '';
    return true
  }
}
