$("#input-form").one("submit", function() {
    var inputq1 = encodeURIComponent($("#input-q1").val());
    var inputq2 = encodeURIComponent($("#input-q2").val());
    var inputq3 = encodeURIComponent($("#input-q3").val());
    var q1ID = "entry.1498135098";
    var q2ID = "entry.878692147";
    var q3ID = "entry.2606285";
    var baseURL =
        "https://docs.google.com/forms/d/e/1FAIpQLSdIRbSAdqzTmpUP-Ln9nHVHOkCcdmgIJdE7-dif36pj6tIgTQ/formResponse?";
    var submitRef = "&submit=Submit";
    var submitURL =
        baseURL + q1ID + "=" + inputq1 + "&" + q2ID + "=" + inputq2 + "&" + q3ID + "=" + inputq3 + submitRef;;
    console.log(submitURL);
    $(this)[0].action = submitURL;
    $("#input-feedback").text("Thank You!");
});

