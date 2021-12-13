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
        let pi_status = $("#pi_status").val();
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
})