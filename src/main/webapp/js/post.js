$(function(){
    $(".main_menu a:nth-child(2)").addClass("active");
    $("#add_post").click(function(){
        $(".popup_wrap").addClass("open");
    })
    $("#add_posts").click(function(){
        if(confirm("게시글을 등록하시겠습니까?") == false) return;
        let pi_title = $("#pi_title").val();
        let pi_i_seq = $("#pi_i_seq").val();
        let pi_sub = $("#pi_sub").val();
        let pi_i_seq = $("#pi_i_seq").val();
        let pi_status = $("#pi_status option:selected").val();
        let pi_rq_seq = $("#pi_rq_seq").val();
    
        let data = {
            pi_title : post_title,
            pi_i_seq : post_i_seq,
            pi_sub : post_sub,
            pi_i_seq : post_i_seq,
            pi_status : post_status,
            pi_rq_seq : post_rq_seq
        }
        $.ajax({
            type:"post",
            url:"/post/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                if(r.status)
                    location.reload();
            }
        })
    })
    $("#cancel_posts").click(function(){
        if(confirm("취소하시겠습니까?\n(입력된 정보는 저장되지 않습니다.)") == false) return;
        
        $("#pi_title").val("");
        $("#pi_i_seq").val("");
        $("#pi_sub").val("");
        $("#pi_i_seq").val("");
        $("#pi_status").val("1").prop("selected", true);
        $("#pi_rq_seq").val("");
        
        $(".popup_wrap").removeClass("open");
    })

    $(".delete_btn").click(function(){
        if(confirm("게시글을 삭제하시겠습니까?\n(이 동작은 되돌릴 수 없습니다.)")==false) return;
        let seq = $(this).attr("data-seq");
        $.ajax({
            type:"delete",
            url:"/post/delete?seq="+seq,
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    });
})