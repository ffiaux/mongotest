/**
 * Created by ffiaux on 24/05/2016.
 */
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/list"
    }).then(function(data) {
        for(var i=0; i<data.length; i++) {
            alert("");
        }
    });
});