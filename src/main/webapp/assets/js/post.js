$(function(){
    $(".main_menu a:nth-child(2)").addClass("active");
    $("#add_post").click(function(){
        $(".popup_wrap").addClass("open");
        $("#add_posts").css("display", "inline-block");
        $("#modify_posts").css("display", "none");
        $(".popup .top_area h2").html("게시글 추가");
        $(".popup .top_area p").html("게시글 내용을 입력해주세요.")
    })
    $("#add_posts").click(function(){
        if(confirm("게시글을 등록하시겠습니까?") == false) return;
        let post_title = $("#post_title").val();
        let post_i_seq = $("#post_i_seq").val();
        let post_sub = $("#post_sub").val();
        let post_status = $("#post_status option:selected").val();
        let post_rq_seq = $("#post_rq_seq").val();
    
        let data = {
            pi_title : post_title,
            pi_i_seq : post_i_seq,
            pi_sub : post_sub,
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
        
        $("#post_title").val("");
        $("#post_i_seq").val("");
        $("#post_sub").val("");
        $("#post_i_seq").val("");
        $("#post_status").val("1").prop("selected", true);
        $("#post_rq_seq").val("");
        
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
    let modify_data_seq = 0;

    $(".modify_btn").click(function(){
        modify_data_seq = $(this).attr("data-seq");
        $(".popup_wrap").addClass("open");
        $("#add_posts").css("display", "none");
        $("#modify_posts").css("display", "inline-block");
        $(".popup .top_area h2").html("게시글 수정");
        $(".popup .top_area p").html("수정할 내용을 입력해주세요");

        $.ajax({
            type:"get",
            url:"/post/get?seq="+$(this).attr("data-seq"),
            success:function(r){
                console.log(r);
                $("#post_title").val(r.data.pi_title);
                $("#post_status").val(r.data.pi_status).prop("selected", true);
                $("#post_sub").val(r.data.pi_sub);
                $("#post_i_seq").val(r.data.pi_i_seq);
                $("#post_rq_seq").val(r.data.pi_rq_seq).prop("selected", true);
            }
        })
    })
    $("#modify_posts").click(function(){
        // alert(modify_data_seq)
        if(confirm("수정하시겠습니까?") == false) return;

        let post_title = $("#post_title").val();
        let post_i_seq = $("#post_i_seq").val();
        let post_sub = $("#post_sub").val();
        let post_status = $("#post_status option:selected").val();
        let post_rq_seq = $("#post_rq_seq").val();
    
        let data = {
            pi_seq:modify_data_seq,
            pi_title : post_title,
            pi_i_seq : post_i_seq,
            pi_sub : post_sub,
            pi_status : post_status,
            pi_rq_seq : post_rq_seq
        }
        $.ajax({
            type:"patch",
            url:"/post/update",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    })
    $("#search_btn").click(function(){
        location.href="/post?keyword="+$("#keyword").val();
    })
    $("#keyword").keydown(function(e){
        console.log(e.keyCode)
        if(e.keyCode == 13){
            $("#search_btn").trigger("click");
        }
    })
})