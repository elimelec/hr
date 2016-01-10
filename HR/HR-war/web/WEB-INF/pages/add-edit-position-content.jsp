<form id="add-edit-form" action="add-edit-position" method="POST">
    <input type="name" placeholder="Name" name="name" value="${position.name}"/>
    <input type="hidden" name="id" value="${id}"/>
    <input type="submit" value="ok"/>
</form>

<textarea form ="add-edit-form" 
          placeholder="Description" 
          name="position_description" 
          id="position_description_id" 
          rows="20" cols="35" >${position.responsabilitati}</textarea>
