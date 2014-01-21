basePath = location.protocol + "//" + location.host + contextPath

function logout(){
	$.removeCookie('ticket');
	window.location.href=basePath;
}
