import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const Form = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
`;

const Label = styled.label`
  margin-bottom: 10px;
  font-weight: bold;
`;

const Input = styled.input`
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 300px;
`;

const Textarea = styled.textarea`
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 300px;
  height: 200px;
`;

const Button = styled.button`
  padding: 10px 20px;
  border: none;
  background-color: #007bff;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
`;

function Write() {
    const [Title, setTitle] = useState("");
    const [Content, setContent] = useState("");
    const [Nickname, setNickname] = useState("");
    const navigator = useNavigate();

    const onTitleHandler = (event) => {
        setTitle(event.currentTarget.value);
    };

    const onContentHandler = (event) => {
        setContent(event.currentTarget.value);
    };

    const onNicknameHandler = (event) => {
        setNickname(event.currentTarget.value);
    };

    const onSubmitHandler = (event) => {
        event.preventDefault();
        let data = {
            title: Title,
            content: Content,
            nickname: Nickname,
        };

        axios
            .post("/command-service/api/v1/board/register", data)
            .then((response) => {
                console.log(response);
                navigator("/");
            })
            .catch((error) => {
                console.error(error);
            });
    };

    return (
        <div>
            <Form onSubmit={onSubmitHandler}>
                <Label>제목</Label>
                <Input
                    value={Title}
                    type="text"
                    onChange={onTitleHandler}
                    placeholder="제목"
                />
                <Label>내용</Label>
                <Textarea
                    value={Content}
                    onChange={onContentHandler}
                    placeholder="내용"
                />
                <Label>닉네임</Label>
                <Input
                    onChange={onNicknameHandler}
                    type="text"
                    value={Nickname}
                    placeholder="닉네임"
                />
                <Button type="submit">저장하기</Button>
            </Form>
        </div>
    );
}

export default Write;
