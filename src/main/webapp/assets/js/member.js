$(function(){
    $(".main_menu a:nth-child(2)").addClass("active");
    $("#add_member").click(function(){
        $(".popup_wrap").addClass("open");
        $("#add_members").css("dispaly", "inline-block");
        $("#modify_members").css("display", "none");
        $(".popup .top_area h2").html("회원 등록");
        $(".popup .top_area p").html("회원 정보를 입력해주세요.")
    })
    
})