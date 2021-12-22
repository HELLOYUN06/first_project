$(function(){
    $(".main_menu a:nth-child(3)").addClass("active");
    $("#search_cate").click(function(){
        $(".category_search").css("display", "block");
    });
    $("#cate_search_close").click(function(){
        $(".category_search").css("display", "");
    });
    $("#cate_keyword").keyup(function(e){
        if(e.keyCode == 13) $("#cate_search_btn").trigger("click");
    });
    $("#cate_search_btn").click(function(){
        $.ajax({
            url:"/cate/keyword?keyword="+$("#cate_keyword").val(),
            type:"get",
            success:function(r){
                console.log(r);
                $(".search_result ul").html("");
                // 반복을 통해서 만들어주셔야하고
                // 카테고리 정보는 r.list 에 모두 담겨있고,
                // 반복을 활용해서 작성하기 때문에
                for(let i=0; i<r.list.length; i++){
                    let tag =
                        '<li>'+
                            // 여기에 [i] 라고 인덱스 값을 사용해야됩니다.
                            '<a href="#" data-dep-seq="'+r.list[i].ci_seq+'">'+r.list[i].ci_name+'</a>'+
                        '</li>';
                    $(".search_result ul").append(tag);
                }
                $(".search_result ul a").click(function(e){
                    e.preventDefault();
                    let seq = $(this).attr("data-dep-seq");
                    let name = $(this).html();

                    $("#post_cate_name").attr("data-dep-seq", seq);
                    $("#post_cate_name").val(name);

                    $(".search_result ul").html("");
                    $("#cate_keyword").val("");
                    $(".category_search").css("display", "");
                })
            }
        })
    });


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
        let post_state = $("#post_state option:selected").val();
        // let post_rq_seq = $("#post_rq_seq option:selected").val();
        let post_rq_seq = $("#post_cate_name").attr("data-dep-seq");
    
        let data = {
            pi_title : post_title,
            pi_i_seq : post_i_seq,
            pi_sub : post_sub,
            pi_state : post_state,
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
        $("#post_state").val("1").prop("selected", true);
        $("#post_rq_seq").val("").prop("selected", true);
        
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
                $("#post_cate_name").val(r.data.category_name);
                $("#post_cate_name").attr("data-dep-seq", r.data.pi_rq_seq);
                $("#post_title").val(r.data.pi_title);
                $("#post_state").val(r.data.pi_state).prop("selected", true);
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
        let post_state = $("#post_state option:selected").val();
        // let post_rq_seq = $("#post_rq_seq option:selected").val();
        let post_rq_seq = $("#post_cate_name").attr("data-dep-seq");
    
        let data = {
            pi_seq:modify_data_seq,
            pi_title : post_title,
            pi_i_seq : post_i_seq,
            pi_sub : post_sub,
            pi_state : post_state,
            pi_rq_seq : post_rq_seq
        }
        // console.log(JSON.stringify(data) )
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
    $("#search_cate").click(function(){

    })
})