package org.acme;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.ClassReactive;

@ClassReactive
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message{
    public static final int HELLO = 0;
    public static final int GOODBYE = 1;

    @JsonProperty("status")
    private int ステータス;
    @JsonProperty("message")
    private String メッセージ;

    @JsonIgnore
    private Boolean dummy;
}