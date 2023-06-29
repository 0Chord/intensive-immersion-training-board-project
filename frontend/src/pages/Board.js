import {Link, useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import styled from "styled-components";

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
`;

const BoardContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
`;

const BoardHeader = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 10px;
`;

const BoardHeaderItem = styled.div`
  font-weight: bold;
`;

const BoardTitle = styled.textarea`
  width: 100%;
  height: 80px;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
`;

const BoardContent = styled.div`
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
`;

const Button = styled.button`
  padding: 10px 20px;
  margin-top: 10px;
  border: none;
  background-color: #007bff;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
`;

const CommentTable = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const CommentTableHead = styled.thead`
  background-color: #f5f5f5;
`;

const CommentTableHeader = styled.th`
  padding: 10px;
  text-align: left;
`;

const CommentTableBody = styled.tbody``;

const CommentTableRow = styled.tr`
  &:nth-child(even) {
    background-color: #f9f9f9;
  }
`;

const CommentTableCell = styled.td`
  padding: 10px;
`;

const CommentDeleteButton = styled.button`
  padding: 5px 10px;
  margin: 0 5px;
  border: none;
  background-color: #dc3545;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
`;

const CommentForm = styled.form`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
`;

const CommentLabel = styled.label`
  margin-bottom: 10px;
  font-weight: bold;
`;

const CommentInput = styled.input`
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 300px;
`;

function Board() {
    const params = useParams().id;
    const navigator = useNavigate();
    const [Board, setBoard] = useState({});
    const [Comment, setComment] = useState([]);
    const [Ment, setMent] = useState("");
    const [Nickname, setNickname] = useState("");

    const onMentHandler = (event) => {
        setMent(event.currentTarget.value);
    };

    const onNicknameHandler = (event) => {
        setNickname(event.currentTarget.value);
    };

    const onSubmitHandler = (event) => {
        event.preventDefault();

        let body = {
            comment: Ment,
            nickname: Nickname
        };

        axios
            .post(`/command-service/api/v1/comment/${params}`, body)
            .then((response) => {
                console.log(response.data);
                window.location.reload();
            })
            .catch((error) => console.error(error));
    };

    useEffect(() => {
        axios
            .get(`/query-service/api/v1/query/board/search/${params}`)
            .then((response) => {
                setBoard(response.data);
            })
            .catch((error) => console.error(error));
        axios
            .get(`/query-service/api/v1/comment/all/${params}`)
            .then((response) => {
                setComment(response.data);
            })
            .catch((error) => console.error(error));
    }, []);

    const deleteBoard = () => {
        axios
            .delete(`/command-service/api/v1/board/delete-board/${params}`)
            .then((response) => {
                navigator("/");
            })
            .catch((error) => console.error(error));
    };

    const onDeleteComment = (id) => {
        axios
            .delete(`/command-service/api/v1/comment/delete-comment/${id}`)
            .then((response) => {
                console.log(response);
                window.location.reload();
            })
            .catch((error) => console.error(error));
    };

    const obj = {
        header: ["번호", "댓글", "닉네임", "게시일"],
    };

    return (
        <Container>
            <BoardContainer>
                <BoardHeader>
                    <BoardHeaderItem>번호: {Board.id}</BoardHeaderItem>
                    <BoardHeaderItem>생성일자: {Board.createdAt}</BoardHeaderItem>
                </BoardHeader>
                <BoardTitle value={Board.title} readOnly/>
                <BoardContent>{Board.content}</BoardContent>
                <Button onClick={deleteBoard}>삭제</Button>
            </BoardContainer>

            <CommentTable>
                <CommentTableHead>
                    <tr>
                        {obj.header.map((item) => (
                            <CommentTableHeader key={item}>{item}</CommentTableHeader>
                        ))}
                        <CommentTableHeader>삭제</CommentTableHeader>
                    </tr>
                </CommentTableHead>
                <CommentTableBody>
                    {Comment.map((comment) => (
                        <CommentTableRow key={comment.id}>
                            <CommentTableCell>{comment.id}</CommentTableCell>
                            <CommentTableCell>{comment.comment}</CommentTableCell>
                            <CommentTableCell>{comment.nickname}</CommentTableCell>
                            <CommentTableCell>{comment.createdDate}</CommentTableCell>
                            <CommentTableCell>
                                <CommentDeleteButton
                                    onClick={() => onDeleteComment(comment.id)}
                                >
                                    삭제
                                </CommentDeleteButton>
                            </CommentTableCell>
                        </CommentTableRow>
                    ))}
                </CommentTableBody>
            </CommentTable>

            <CommentForm onSubmit={onSubmitHandler}>
                <CommentLabel>댓글 내용</CommentLabel>
                <CommentInput
                    type="text"
                    value={Ment}
                    onChange={onMentHandler}
                    placeholder="댓글"
                />
                <CommentLabel>글쓴이</CommentLabel>
                <CommentInput
                    type="text"
                    value={Nickname}
                    onChange={onNicknameHandler}
                    placeholder="글쓴이"
                />
                <Button type="submit">댓글쓰기</Button>
            </CommentForm>

            <Link to={"/"}>
                <Button>홈으로</Button>
            </Link>
        </Container>
    );
}

export default Board;

