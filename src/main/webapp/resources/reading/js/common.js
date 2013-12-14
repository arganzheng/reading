basePath = location.protocol + "//" + location.host + contextPath

function logout(){
	$.removeCookie('user_name');
	$.removeCookie('auth_cm_com_session_key');
	window.location.href=basePath;
}
