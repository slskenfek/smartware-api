# 💼 SmartWare API

> "재택근무에 특화된 스마트 그룹웨어 플랫폼의 API 서버입니다."

SmartWare는 출퇴근 관리, 업무 보드, 전자결재, 채팅, 실시간 알림, 로그 추적 기능을 포함한  
**All-in-One 재택근무 그룹웨어 서비스**입니다.

이 저장소는 API 서버이며, `smartware-front` 앱과 연동되어 동작합니다.

---

## 🎯 프로젝트 목적

- 재택근무 환경에서의 실시간 업무 흐름 통합
- 모든 사용자 활동 로그를 기반으로 추적 및 감사
- 원격 제어 기능을 통한 업무 지원
- 쉽고 똑똑한 그룹웨어 간소화  
---

## ✅ 주요 기능 (API 관점)

| 기능 | 설명                                         |
|----|--------------------------------------------|
| 출퇴근 기록 | 위치/IP 기반 출근 등록, 근무 시간 자동 계산                |
| 업무 보드 | Kanban 기반 업무 등록, 상태/담당자 변경                 |
| 전자결재 | 결재선 지정, 승인/반려 흐름, 승인 이력 기록                 |
| 실시간 채팅 | WebSocket 기반 실시간 팀 채널 및 1:1 채팅             |
| 알림 시스템 | 업무 상태 변경, 결재 요청 등 Slack/Email 연동           |
| 로그 수집 | Kafka 기반 유저 이벤트 로그 → 분석 시스템 연동 (gather 활용) |
| 원격 | 원격 근무 핵심 서비스로 원격 제어하여 업무 효율성 극대화           |

---

## 🧰 기술 스택

| 영역 | 스택                                 |
|------|------------------------------------|
| Language | Java 21                            |
| Framework | Spring Boot 3.4.7                  |
| Database | PostgreSQL                         |
| Auth | Spring Security + JWT              |
| Messaging | gather  (로그 및 알림 처리) |
| Realtime | Spring WebSocket                   |
| Build Tool | Gradle (Kotlin DSL)                |
| Infra | Docker, jenkins, k8s               |
| Docs | Swagger (Springdoc OpenAPI 2.x)    |

---

## 특성
- 모든 로직은 API에서 관리 합니다.

