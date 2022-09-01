//
// console.log("js file connected")
//
// function addMember() {
//     console.log("add button was clicked")
// }


$(document).ready(function () {
    $("#add-member-btn").click(function () {
        console.log("add button was clicked")

        let name = $("#new-name").val()
        let phoneNumber = $("#phone-number").val()

        console.log(name)
        console.log(phoneNumber)

        $.get('/add', {name: name, phoneNumber: phoneNumber}, function () {
            console.log("ok")
            $("#new-name").val("")
            $("#phone-number").val("")
        })

        // let messageText = $("#message").val();
        // console.log("start sending message: " + messageText);
        // if (messageText === "") return; // if message is empty
        // $.get('/message/send', { userName: userName, message: messageText}, function(data) {
        //     console.log("message was sent");
        //     $("#message").val("")
        // })
    })
});