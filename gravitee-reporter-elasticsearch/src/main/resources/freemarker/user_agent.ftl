<@compress single_line=true>
{
  "user_agent" : {
    "if": "ctx['user-agent'] != null",
    "field" : "user-agent"
  }
}
</@compress>