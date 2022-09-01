
$(document).ready(function () {

    $("#new-member").click(function (){
        $("#add-member").css("visibility", "visible");
    })

    $("#cancel-btn").click(function (){
        $("#new-name").val("")
        $("#phone-number").val("")
        $("#add-member").css("visibility", "hidden");
    })

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
            $("#add-member").css("visibility", "hidden");
        })
    })
});