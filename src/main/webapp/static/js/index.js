// var settings = {
//     "url": "http://localhost:8080/api/author/getbyid/1",
//     "method": "GET",
//     "timeout": 0,
// };
//
// $.ajax(settings).done(function (response) {
//     console.log(response);
//     console.log(authorId);
//
// });
//
//
// $(document).ready(function() {
//     $.ajax({
//         url: "http://localhost:8080/api/author/getbyid/1"
//     }).then(function(data) {
//         $('.author-id').append(data.authorId);
//         $('.author-firstName').append(data.firstName);
//         $('.author-lastName').append(data.lastName);
//         $('.author-country').append(data.country);
//
//     });
// });
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/author/getall"
    }).then(function(data) {

        for (i = 0; i < data.authors.length; i++) {
            $('#authors').append("<ul>" +
                "<li>"+data.authors[i].authorId+"</li>" +
                "<li>"+data.authors[i].firstName+"</li>"+
                "<li>"+data.authors[i].lastName+"</li>"+
                "</ul>");
        }

    });
});