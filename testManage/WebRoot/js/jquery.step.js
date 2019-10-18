$(function() {
		var step= $("#myStep").step({
			animate:true,
			initStep:1,
			speed:1000
		});		
		$("#preBtn").click(function(event) {
			var yes=step.preStep();
		});
		$("#applyBtn").click(function(event) {		
			
		   //验证码（这里不需要） var code = $.trim($("#Verification").val());
			//var phone =/[1][3-9][0-9]{9,9}/;
			var email=/(^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$)/;
		  var emails = $.trim($("#email").val());//获取用户输入的邮箱
		if ($.trim(emails) == "") {
			Tip('请填写邮箱！');
			$("#email").focus();
			return;
		}
		if(!email.exec(emails)){

				Tip('邮箱输入格式不正确,请重新输入！');
				$("#email").focus();
			return;
			}
		/*if ($.trim(code) == "") {
			Tip('动态密码未填写！');
			$("#Verification").focus();
			return;
		}   */
		//验证邮箱是否已经注册
		
		 checkEmail(emails,step);
		
		return;	
		});
		$("#submitBtn").click(function(event) {
			   var txtconfirm = $.trim($("#confirmpwd").val());
	           var txtPwd = $("#password").val();
	          if ($.trim(txtPwd) == "") {
	
	         	Tips('请输入你要设置的密码！');
		       $("#txtPwd").focus();
		      return;
		
	            }
			  if($.trim(txtconfirm) == "") {
	
	         	Tips('请再次输入密码！');
		       $("#txtconfirm").focus();
		      return;
		
	            }
			  if( $.trim(txtconfirm) != $.trim(txtPwd) ) {
	
	         	Tips('你输入的密码不匹配，请从新输入！');
		       $("#txtconfirm").focus();
		      return;
		
	            }
			  submitRegist(step);
			
			
             
			
		});
		/* function lazyGo() {
	         var sec = $("#sec").text();
	            $("#sec").text(--sec);
	            if (sec > 0)
	         	setTimeout("lazyGo();", 1000);
	            else
		window.location.href = "login.jsp";
}*/
		$("#phone").onfocus=function(){
			alert();
			$(".tishi").hide();
		};
		$("#goBtn").click(function(event) {
			var yes=step.goStep(3);
		});	
	});
 function checkEmail(emails,step){//检查邮箱是否已经注册
	var data={t_name:"",t_email:emails};
	
	$.ajax({
		type:"POST",
		url:"/testManage/registerCheck.action",
		data:JSON.stringify(data),
		
		contentType : "application/json;charset=UTF-8",
		dataType:'json',
		success:function(data){
			
			if(data.result=="1"){
				//用户名或邮箱已经存在
				Tip('该邮箱已经被注册！请重新输入');
				
			}else{
				//用户名或邮箱不存在,可以进行下一步
				var yes=step.nextStep();
				
			}
			
		}
	});

}
function submitRegist(step){
	 var emails = $.trim($("#email").val());//获取用户输入的邮箱
	 var password = $("#password").val();//获取用户输入的密码
	 var data={t_name:"",t_pass:password,t_email:emails};
	 $.ajax({
			type:"POST",
			url:"/testManage/addTeacher.action",
			data:JSON.stringify(data),		
			contentType : "application/json;charset=UTF-8",
			dataType:'json',
			success:function(data){
				
				if(data.result=="1"){
					//注册成功
					var yes=step.nextStep();
					$(function () { setTimeout("lazyGo();", 1000); });
				}else{
					//注册失败
					alert("注册失败！未知异常")
					
				}
			}
		});
}
function lazyGo() {
    var sec = $("#sec").text();
       $("#sec").text(--sec);
       if (sec > 0)
    	setTimeout("lazyGo();", 1000);
       else
window.location.href = "login.jsp";
}
(function (factory) {
    "use strict";
    if (typeof define === 'function') {
        // using CMD; register as anon module
      define.cmd&&define('jquery-step', ['jquery'], function (require, exports, moudles) {
            var $=require("jquery");
            factory($);
            return $;
        });
      define.amd&&define(['jquery'], factory);
    } else {
        // no CMD; invoke directly
        factory( (typeof(jQuery) != 'undefined') ? jQuery : window.Zepto );
    }
}

(function($){
  $.fn.step = function(options) { 
      var opts = $.extend({}, $.fn.step.defaults, options);
      var size=this.find(".step-header li").length;
      var barWidth=opts.initStep<size?100/(2*size)+100*(opts.initStep-1)/size : 100;
      var curPage=opts.initStep;

      this.find(".step-header").prepend("<div class=\"step-bar\"><div class=\"step-bar-active\"></div></div>");
      this.find(".step-list").eq(opts.initStep-1).show();
      if (size<opts.initStep) {
        opts.initStep=size;
      }
      if (opts.animate==false) {
        opts.speed=0;
      }
      this.find(".step-header li").each(function (i, li) {
        if (i<opts.initStep){
          $(li).addClass("step-active");
        }
        //$(li).prepend("<span>"+(i+1)+"</span>");
        $(li).append("<span>"+(i+1)+"</span>");
    });
    this.find(".step-header li").css({
      "width": 100/size+"%"
    });
    this.find(".step-header").show();
    this.find(".step-bar-active").animate({
        "width": barWidth+"%"},
        opts.speed, function() {
        
    });

      this.nextStep=function() {
        if (curPage>=size) {
          return false;
        }
        return this.goStep(curPage+1);
      }

      this.preStep=function() {
        if (curPage<=1) {
          return false;
        }
        return this.goStep(curPage-1);
      }

      this.goStep=function(page) {
        if (page ==undefined || isNaN(page) || page<0) {
          if(window.console&&window.console.error){
            console.error('the method goStep has a error,page:'+page);
          }
        return false;
        }
        curPage=page;
        this.find(".step-list").hide();
        this.find(".step-list").eq(curPage-1).show();
        this.find(".step-header li").each(function (i, li) {
          $li=$(li);
          $li.removeClass('step-active');
          if (i<page){
            $li.addClass('step-active');
            if(opts.scrollTop){
             $('html,body').animate({scrollTop:0}, 'slow');
            }
        }
      });
      barWidth=page<size?100/(2*size)+100*(page-1)/size : 100;
        this.find(".step-bar-active").animate({
          "width": barWidth+"%"},
          opts.speed, function() {
            
        });
        return true;
      }
      return this;
  };
   
  $.fn.step.defaults = {
      animate:true,
      speed:500,
    initStep:1,
    scrollTop:true
  };
})
 );  