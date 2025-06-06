import os
from opencc import OpenCC

# 使用簡體轉繁體（s2t: 簡體到繁體）
converter = OpenCC('s2twp') 

# 要處理的副檔名清單
target_extensions = ['.js', '.ts', '.vue', '.json', '.md', '.py', '.txt', '.sql','.xml','.java','.cs','.properties']

# 遞迴處理所有檔案
def convert_directory(root_dir):
    for foldername, _, filenames in os.walk(root_dir):
        for filename in filenames:
            filepath = os.path.join(foldername, filename)
            if any(filename.lower().endswith(ext) for ext in target_extensions):
                print(f"轉換中: {filepath}")
                try:
                    with open(filepath, 'r', encoding='utf-8') as f:
                        content = f.read()

                    converted = converter.convert(content)

                    with open(filepath, 'w', encoding='utf-8') as f:
                        f.write(converted)

                except Exception as e:
                    print(f"⚠️ 錯誤處理檔案 {filepath}: {e}")

# 執行轉換
if __name__ == '__main__':
    current_dir = os.path.dirname(os.path.abspath(__file__))
    convert_directory(current_dir)
    print("✅ 所有檔案轉換完成")
