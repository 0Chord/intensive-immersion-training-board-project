import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import styled from "styled-components";

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const Th = styled.th`
  padding: 10px;
  border: 1px solid #ccc;
  background-color: #f2f2f2;
  font-weight: bold;
  text-align: center;
`;

const Td = styled.td`
  padding: 10px;
  border: 1px solid #ccc;
  text-align: center;
`;

const Button = styled.button`
  padding: 10px 20px;
  border: none;
  background-color: #007bff;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
`;

const CenteredText = styled.h1`
  text-align: center;
`;

function Home() {
    const [Board, setBoard] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios
            .get("/query-service/api/v1/query/board/search-boards")
            .then((response) => {
                setBoard(response.data);
            })
            .catch((error) => console.error(error));
    }, []);

    const obj = {
        header: ["번호", "제목", "닉네임", "게시일"],
    };

    return (
        <div>
            <CenteredText>게시판</CenteredText>
            <Table>
                <thead>
                <tr>
                    {obj.header.map((item, index) => (
                        <Th key={index}>{item}</Th>
                    ))}
                </tr>
                </thead>
                <tbody>
                {Board.map((board) => (
                    <tr key={board.id}>
                        <Td>
                            <Link to={`/board/${board.id}`}>{board.id}</Link>
                        </Td>
                        <Td>{board.title}</Td>
                        <Td>{board.nickname}</Td>
                        <Td>{board.createdDate}</Td>
                    </tr>
                ))}
                </tbody>
            </Table>
            <Link to={"/write-board"}>
                <Button>글쓰기</Button>
            </Link>
        </div>
    );
}

export default Home;
