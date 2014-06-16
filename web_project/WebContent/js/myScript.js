function passwordControl(){
	var password = $('#password').val();
	if(password.length == 0){
		$('#password_information').html('&diams; Şifre boş bırakılamaz');
		return false;
	}
	else if(password.length < 8 ){
		$('#password_information').html('&diams; Şifreniz en az 8 karakter olmalıdır.');
		return false;
		
	}else{
		$('#password_information').html('');
		return true;
	}
};
function retryPasswordControl(){
	var password = $('#password').val();
	var retryPassword = $('#retryPassword').val();
	if(retryPassword.length < 8 ){
			$('#retry_password_information').html('&diams; Şifreniz en az 8 karakter olmalıdır.');
			return false;
	}
	else if(password != retryPassword){
		$('#retry_password_information').html('&diams; Şifreler uyuşmuyor');
		return false;
	}
	else{
		$('#retry_password_information').html('');
		return true;
	}
};

$( document ).ready(function() {
	$( "#password" ).focusout(passwordControl);
	$( "#retryPassword" ).focusout(retryPasswordControl);
	$( "#signUp" ).submit(function() {
		if(passwordControl() && retryPasswordControl()){
			return true;
		}
		else{
			return false;
		}
	});	
});
