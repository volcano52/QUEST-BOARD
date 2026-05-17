# QUEST-BOARD
A fun, immersive RPG-themed job board for university students. Real jobs transformed into epic quests with AI (Ollama) + beautiful fantasy design.

<div align="center">
  <h1>QuestBoard</h1>
  <p><strong>Real Jobs. Epic Quests.</strong></p>
  
  <img src="https://img.shields.io/badge/Next.js-15-black?style=for-the-badge&logo=next.js" alt="Next.js"/>
  <img src="https://img.shields.io/badge/TypeScript-blue?style=for-the-badge&logo=typescript" alt="TypeScript"/>
  <img src="https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css" alt="Tailwind"/>
  <img src="https://img.shields.io/badge/Ollama-Local_AI-purple?style=for-the-badge" alt="Ollama"/>
  
  <br/><br/>
  
  **A fantasy RPG-styled job board where university students can find internships, part-time jobs, and campus opportunities presented as epic quests.**
</div>

---

## ✨ Features

- **Real Job Listings** — Pulls actual jobs from We Work Remotely, Remotive, and more
- **AI-Powered Quest Transformation** — Uses **Ollama** (local LLM) to turn normal jobs into immersive fantasy quests
- **Beautiful RPG Aesthetic** — Dark wood, parchment scrolls, glowing runes, and immersive UI
- **Gamification** — XP system, levels, adventurer titles, and quest log
- **AI Cover Letter Generator** — Generate personalized cover letters instantly
- **Student Profile** — Track your progress and abilities
- **Fully Responsive** — Works great on mobile

## 🎮 How It Works

Every real job becomes a **Quest**:
- "Software Engineering Intern at Stripe" → **"The Enchanted Ledger: Summer Code Quest"**

Students can browse, accept quests, track applications, and level up their adventurer profile.

## 🛠️ Tech Stack

- **Framework**: Next.js 15 (App Router) + TypeScript
- **Styling**: Tailwind CSS + Custom Fantasy Theme
- **Database**: SQLite + Drizzle ORM
- **Authentication**: NextAuth.js
- **AI**: Ollama (llama3.1 or similar)
- **Animations**: Framer Motion

## 🚀 Quick Start

```bash
# 1. Clone the repo
git clone https://github.com/yourusername/questboard.git

# 2. Install dependencies
npm install

# 3. Setup database
npm run db:push

# 4. Run Ollama (llama3.1 model recommended)
ollama run llama3.1

# 5. Start the app
npm run dev



questboard/
├── package.json
├── README.md
├── tailwind.config.ts
├── next.config.mjs
├── drizzle/
│   └── schema.ts
├── lib/
│   ├── db.ts
│   └── ollama.ts
├── app/
│   ├── globals.css
│   ├── layout.tsx
│   ├── board/page.tsx
│   ├── profile/page.tsx
│   ├── my-quests/page.tsx
│   ├── admin/page.tsx
│   ├── auth/signin/page.tsx
│   ├── api/
│   │   ├── auth/[...nextauth]/route.ts
│   │   ├── ingest/rss/route.ts
│   │   ├── seed/route.ts
│   │   ├── quests/accept/route.ts
│   │   └── generate-cover-letter/route.ts
│   └── quests/[id]/
│       └── page.tsx
└── components/
    ├── RPGHeader.tsx
    ├── QuestCard.tsx
    └── QuestLogCard.tsx
