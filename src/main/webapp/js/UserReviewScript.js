function sendEmail() {  
    var email = $("#uEmail").val();
    var objMessage = { "email": email };
    $.ajax({
        url: 'UserReviewServlet',
        type: 'GET',
        contentType: 'application/json',
        data: objMessage,
        dataType: 'json',
        success: function(value) {
           // $("#test").val = value.firstName;
            console.log("Success");
           // console.log("value of name is:" + value.firstName);
        }
    });
}


function refresh() {
    $.ajax({
        url: 'UserReviewServlet',
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        success: refreshUser
    });
}

function refreshUser(val) {
    var user = val;
    console.log("job "+user.job);
    
    if(typeof user.firstName  !== "undefined")
    {
       $("#userData p").remove();
       $("#userData h1").remove();
        console.log("user first name "+user.firstName);
        $('#userData').append('<h1 title="first name" class="title">' + user.firstName + '</h1><p title="last name">' + user.lastName+ '</p ><p title="User Jop">' + user.job+ '</p ><p title="User Email">' + user.email+ '</p > <p title="Credit Lemit">' + user.creditLimit.toString()+ '</p > <p title="Credit number">' + user.creditNo + '</p>'); 
    }   
    else{
        console.log("undefined");
    }
    
}
