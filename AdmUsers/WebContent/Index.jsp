<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="Content/css/mui.css">
	<script type="application/javascript" src="Content/js/mui.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login ADM USER</title>
</head>
<body>
	<div class='mui-container' style='margin-bottom: 5%'>
		<div class="mui-panel" style="margin-top:10%; width:50%;box-shadow: 0 3px 3px 0 rgba(99, 165, 249, 0.9),0 2px 10px 0 rgba(0,0,0,0.12);" id="principal">
			 <p class="sub_titulo" style="text-align:center">REINICIO DE CONTRASEÑA ACTIVE DIRECTORY</p>
                    <form action="ServletAuthUser.do" method="post">  
                    <div class="mui-textfield">
                        <input type="text" required name="userName" id="userName" />
                        <label>Nombre de Usuario</label>
                    </div>
                    <div class="mui-textfield">
                        <input type="password" required name="userPass" id="userPass"/>
                        <label>Contraseña</label>
                    </div>
                    
                      <div style="clear:left; margin-left:20%;">                    
                        <button type="submit" class="mui-btn mui-btn--intro">Login</button>
                    </div>   
                </form>		
		</div>
	</div>
</body>
</html>