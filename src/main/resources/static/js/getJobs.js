/**
 * 
 */
$(document).ready(function() {
	$.ajaxSetup ({
        cache: false
    });
	$("#product_view").hide();
	
    getJobs();
    $("#jobform").submit(function(event){
    	event.preventDefault();
        postJob();
    });
    //for dynamicaly generated html tags u need to do this 
    $('.tbody').on('click','#jobDetail',function()
    		{
    	//gets the href element inside anchor jobDetail
    	     var href=$(this).attr('href');
    	     getJobBYId(href);
    	     //alert(href);
    		});
    $('.tbody').on('click','#deleteDetail',function()
    		{
    	//gets the href element inside anchor jobDetail
    	     var href=$(this).attr('href');
    	     deleteJobByID(href);
    	     
    	     //alert(href);
    		});
    
    });
    


    function getJobs()
    {
    	$.ajax({
            url: "/jobs"
        }).then(function(data) {
        $.each(data,function(id, job)
        {
        	console.log("GET "+job);
          $('.tbody').append('<tr id='+job.id+'>'+
        		  console.log('statuss: '+job.status)+
        		  
          '<td>'+job.position+'</td>'+
//          '<td>'+job.jobDescription+'</td>'+
          '<td>'+job.dateApplied+'</td>'+
          '<td>'+job.employer.companyName+'</td>'+
          '<td>'+job.employer.employerType+'</td>'+
          '<td>'+job.employer.address.email+'</td>'+
          '<td>'+job.employer.address.state+'</td>'+
          '<td>'+job.employer.address.source+'</td>'+
          '<td>'+'<a href="'+job.employer.address.website+'"class="btn btn-warning" role="button">Goto Website</a>'+'</td>'+
          '<td>'+'<a id="jobDetail" href="jobs/'+job.id+'"class="btn btn-info" role="button">View JobDescription</a>'
          +'</td>'
          +'<td>'+'<a id="deleteDetail" href="jobs/'+job.id+'"class="btn btn-danger" role="button">Delete Application</a>' +'</td>'
      +'</tr>')
      checkDisabledJob(job);
       
      
          
        });
});
    }
    
    
    function deleteJobByID(href)
    {
    	event.preventDefault();
    	$.ajax({
    		url:href,
    		type:'DELETE',
    		success:function()
    		{
    			$('.tbody').children().remove();
    	    	getJobs();
    		}
    	});
    }

function ConvertFormToJSON(form){
    var array = jQuery(form).serializeArray();
    var json = {};
    
    jQuery.each(array, function() {
        json[this.name] = this.value || '';
    });
    
    return json;
}

function getJobBYId(href)
{ 	event.preventDefault();
	$.ajax({
		url:href,
		type:'GET',
		success:function(get)
		{
			console.log(JSON.stringify(get));
			$('.modal-title').html(get.position);
			$('.cName').html(get.employer.companyName);
			$('.embed-responsive-item').attr("src",get.employer.address.website);
			$("#desc").html(get.jobDescription);
			$("#product_view").modal();
			$("#disable").click(function()
					{
				     $.ajax({
				    	 url:'jobs/disable/'+get.id,
				    	 type:'GET'
				     })
					})
					$("#enable").click(function()
					{
				     $.ajax({
				    	 url:'jobs/enable/'+get.id,
				    	 type:'GET'
				     })
					})
		}
	});
}

function checkDisabledJob(job)
{
	console.log("Hi"+job.status);
	if(!job.status)
	   {
   $('#'+job.id+'').css('background-color', '#ef757bd4');    	   
	   }
	else
		{
		$('#'+job.id+'').css('background-color', '#88e27de6');
		}
	}

function postJob()
{
//	var formData = $("#jobform").serializeArray();
//	var data=JSON.stringify(formData);
//	var jobdata={}
	
	var jsonDatas={
		  jobDescription: $("#jobDescription").val(),
		  position: $("#position").val(),
		  employer: {
		    address: {
		      email: $("#email").val(),
		      phoneNumber: $("#phoneNumber").val(),
		      source: $("#source").val(),
		      state: $("#state").val(),
		      street: $("#street").val(),
		      website: $("#website").val()
		    },
		    companyName: $("#companyName").val(),
		    employerType: $("#employerType").val(),
		    
		  },
		  
		};
	
	console.log("from the var: "+JSON.stringify(jsonDatas));
	$.ajax({
	    type: "POST",
	    url: "/jobs",
	    // The key needs to match your method's input parameter (case-sensitive).
	    data: JSON.stringify(jsonDatas),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data){
	    	$('.tbody').children().remove();
	    	getJobs();
	    	},
	    failure: function(errMsg) {
	        alert(errMsg);
	    }
	});
	}