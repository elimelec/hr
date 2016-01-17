<div class="container top_margin">
    <div style="display: table; margin-top: 40px; margin-bottom: 40px;">
        <div style="display: table-row;">
            <div style="display: table-cell;">Name:</div>    
            <div style="display: table-cell;" class="detail">${position.name}</div>
        </div>

        <div style="display: table-row;">
            <div style="display: table-cell;">Department:</div>    
            <div style="display: table-cell;" class="detail">${position.department}</div>
        </div>

        <div style="display: table-row;">
            <div style="display: table-cell;">Requirements:</div>    
            <div style="display: table-cell;" class="detail">${position.cerinte}</div>
        </div>

        <div style="display: table-row;">
            <div style="display: table-cell;">Responsibilities:</div>    
            <div style="display: table-cell;" class="detail">${position.responsabilitati}</div>
        </div>

    </div>
        
    <a class="btn" href="${pageContext.request.contextPath}/apply-for-position">Apply for this job</a> 
</div>