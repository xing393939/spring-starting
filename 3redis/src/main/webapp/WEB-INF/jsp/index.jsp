<!DOCTYPE html>
<html>
<body>
{{#person}}
  Hi {{name}}!
{{/person}}

{{#repo}}
  <b>{{name}}</b>
{{/repo}}
{{^repo}}
  No repos :(
{{/repo}}

{{#todos}}
<h2>{{id}}: {{name}}</h2>
{{/todos}}

</body>
</html>