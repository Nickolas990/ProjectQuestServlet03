$(function(){
    $("#load_btn").click(function(e){
            $.ajax({
                url: "/quest",
                method: "GET",
                dataType: "jsp",
                data : {
                    character: "Grentias"
                },
                error: function (msg) {
                  console.log(msg);
                  alert('error!')
                },
                success: function(data) {
                    console.log(data)
                    alert('success!');
                    $("#content").html(data)
                }
            })
        })
    });
function startDialog(appName, character) {
    $.ajax({
        url: appName + "/quest",
        method: "GET",
        dataType: "html",
        data: {character: character},
        error: function (msg) {
            console.log(msg);
            alert('error');
        },
        success: function(data) {
            $("#content").html(data)
        }
    })
}
function continueDialog(appName, id) {
    $.ajax({
        url: appName + "/quest",
        method: "GET",
        dataType: "html",
        data: {id: id},
        error: function (msg) {
            console.log(msg);
            alert('error');
        },
        success: function(data) {
            $("#content").html(data)
        }
    })
}