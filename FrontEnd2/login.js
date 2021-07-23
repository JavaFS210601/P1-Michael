const url = "http://localhost:8080/P1-Michael/"

window.document.getElementById("loginButton").addEventListener("click", loginFunc);


async function loginFunc() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    }

    console.log(user);
   
    

    let response = await fetch(url + "login", {
        method: "POST",
        body: JSON.stringify(user),
        //credentials: "include"
    });

    console.log(response.status);
    // let data = response.json();
    // console.log(data);
    let data = await response.json();
    if (response.status === 200) {
        
        console.log(data);

        console.log(data.roleId.id);
        console.log("hellooo");
        if (data.roleId.id == 1) {
            window.location.replace("http://127.0.0.1:5500/manager.html");
        }
        else if (data.roleId.id == 2) {
            window.location.replace("http://127.0.0.1:5500/employee.html");
            
        }
        else {
            document.getElementById("login-row").innerText = "Login Succeeded! Redirect failed! Reload the page!"
        }
    
    } else {
        document.getElementById("login-row").innerText = "Login Failed! Refresh the page!";
    }
}