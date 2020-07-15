package com.github.instagram4j.Instagram4J.requests.friendships;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.instagram4j.Instagram4J.models.IGPayload;
import com.github.instagram4j.Instagram4J.requests.IGPostRequest;
import com.github.instagram4j.Instagram4J.responses.IGResponse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IGFriendshipsSetBestiesRequest extends IGPostRequest<IGResponse> {
    private final Long[] _add, _remove;
    
    public IGFriendshipsSetBestiesRequest(boolean add, Long... pks) {
        this._add = add ? pks : null;
        this._remove = !add ? pks : null;
    }
    
    @Override
    protected IGPayload getPayload() {
        return new IGFriendshipsSetBestiesPayload();
    }

    @Override
    public String path() {
        return "friendships/set_besties/";
    }

    @Override
    public Class<IGResponse> getResponseType() {
        return IGResponse.class;
    }
    
    @Data
    @JsonInclude(Include.NON_NULL)
    public class IGFriendshipsSetBestiesPayload extends IGPayload {
        private Long[] add = _add;
        private Long[] remove = _remove;
    }

}