fetch('http://localhost:8080/rest')   //user
    .then(res => { res.json().then(
        user=>{
            let navbarDark = ""
            navbarDark += "<b class=\"text-white\" style=\"font-size: 18px\">"+user.username+"</b>"
            navbarDark += "<span class=\"text-white\"  style=\"font-size: 18px\"> &nbsp with roles: &nbsp </span>"
            navbarDark += "<span class=\"text-white\"  style=\"font-size: 18px\">"
            user.roles.forEach((role) => navbarDark += role.name.replace('ROLE_','')+' ')
            navbarDark += "</span>"
            document.getElementById("navbarDark").innerHTML = navbarDark

            let tableUser = ""
            tableUser += "<tr>"
            tableUser += "<td>"+user.id+"</td>"
            tableUser += "<td>"+user.username+"</td>"
            tableUser += "<td>"+user.age+"</td>"
            tableUser += "<td>"+user.email+"</td>"
            tableUser += "<td>"
            user.roles.forEach((role) => tableUser += role.name.replace('ROLE_','')+" ")
            tableUser += "</td>"
            document.getElementById("userInfo").innerHTML = tableUser
        }
    )})